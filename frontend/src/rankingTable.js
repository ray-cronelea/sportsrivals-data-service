import React from 'react';
import PropTypes from 'prop-types';
import { withStyles } from '@material-ui/core/styles';
import Table from "@material-ui/core/Table/Table";
import TableHead from "@material-ui/core/TableHead/TableHead";
import TableRow from "@material-ui/core/TableRow/TableRow";
import TableCell from "@material-ui/core/TableCell/TableCell";
import TableBody from "@material-ui/core/TableBody/TableBody";
import Paper from "@material-ui/core/Paper/Paper";
import Grid from "@material-ui/core/Grid/Grid";
import CircularProgress from '@material-ui/core/CircularProgress';

const styles = theme => ({
    root: {
        width: '100%',
        marginTop: theme.spacing.unit * 3,
        overflowX: 'auto',
        minWidth: 275,
        maxWidth: 900,
        justify: "center"
    },
    card: {
    },
    table: {
        minWidth: 700,
        tableLayout: 'auto'
    },
    tabbutton: {
        'width': '5%',
    },
    thumbnail: {
        width: "100%"
    },
    progress: {
        marginTop: "50px",
        margin: theme.spacing.unit * 2,
    },
});


class RankingTable extends React.Component{
    constructor(props) {
        super(props);
        this.state = {
            isLoaded: false,
            data: []
        };
    }

    componentDidMount() {
        this.getRankingsForSport();
    }

    componentDidUpdate(prevProps, prevState){
        if (prevProps.sport.id !== this.props.sport.id) {
            if (this.props.sport.id !== null) {

                this.setState({
                    isLoaded: false
                });
                this.getRankingsForSport();
            }
        }
    }

    getRankingsForSport() {
        let sportId = this.props.sport.id;
        let url = './api/teams/search/findBySportOrderByRatingDesc?id=' + sportId;

        console.log("Update Items Url: " + url );

        fetch(url)
            .then(res => res.json())
            .then(
                (result) => {
                    console.log(result);
                    this.setState({
                        isLoaded: true,
                        data: result._embedded
                    });
                },
                (error) => {
                    this.setState({
                        isLoaded: true,
                        error
                    });
                }
            )
    }

    render() {
        const { classes } = this.props;
        const { error, isLoaded, data } = this.state;
        if (error) {
            return <div>Error: {error.message}</div>;
        } else if (!isLoaded) {
            return (
                <div>
                    <CircularProgress className={classes.progress}/>
                </div>
            );
        } else {
            return (
                <Grid container justify = "center">
                    <Paper className={classes.root}>
                        <Table className={classes.table}>
                            <TableHead>
                                <TableRow>
                                    <TableCell className={classes.tabbutton}>Logo</TableCell>
                                    <TableCell>Name</TableCell>
                                    <TableCell>Ranking</TableCell>
                                    <TableCell>Sport</TableCell>
                                    <TableCell>City</TableCell>
                                    <TableCell>State</TableCell>
                                </TableRow>
                            </TableHead>


                            <TableBody>

                                {data.teams.map(row => {
                                    return (
                                        <TableRow key={row.id}>
                                            <TableCell>
                                                <img className={classes.thumbnail} src={row.imageUrl} alt="logo"/>
                                            </TableCell>
                                            <TableCell>{row.name}</TableCell>
                                            <TableCell>{row.rating}</TableCell>
                                            <TableCell>{row.sport.name}</TableCell>
                                            <TableCell>{row.city.name}</TableCell>
                                            <TableCell>{row.state.name}</TableCell>
                                        </TableRow>
                                    );
                                })}

                            </TableBody>
                        </Table>
                    </Paper>
                </Grid>
            );
        }
    }
}

RankingTable.propTypes = {
    classes: PropTypes.object.isRequired,
};

export default withStyles(styles)(RankingTable);
