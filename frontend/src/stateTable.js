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
    modalImage: {
        width: "100px",
        height: "100px"
    },
    cover: {
        width: 151,
    },
    card: {
        display: 'flex',
    },
});


class StateTable extends React.Component{
    constructor(props) {
        super(props);
        this.state = {
            isLoaded: false,
            data: [],
        };
    }

    componentDidMount() {
        this.getRankingsForSport();
    }
    getRankingsForSport() {
        let url = './api/states?size=100&sort=rating,desc';

        fetch(url)
            .then(res => res.json())
            .then(
                (result) => {
                    console.log(result._embedded.states);
                    this.setState({
                        isLoaded: true,
                        data: result._embedded.states,
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

    handleRowClick = (data) => {
        console.log(data.name);
        this.setState({
        });
    }

    render() {
        const { classes } = this.props;
        const { error, isLoaded, data } = this.state;
        if (! this.props.visible){
            return null
        } else if (error) {
            return <div>Error: {error.message}</div>;
        } else if (!isLoaded) {
            return (
                <div>
                    <CircularProgress className={classes.progress}/>
                </div>
            );
        } else {
            return (
                <div>
                    <Grid container justify = "center">
                        <Paper className={classes.root}>
                            <Table className={classes.table}>
                                <TableHead>
                                    <TableRow>
                                        <TableCell className={classes.tabbutton}>Logo</TableCell>
                                        <TableCell>Name</TableCell>
                                        <TableCell>Ranking</TableCell>
                                        <TableCell>Abbreviation</TableCell>
                                        <TableCell>Captial</TableCell>
                                    </TableRow>
                                </TableHead>


                                <TableBody>

                                    {data.map(row => {
                                        return (
                                            <TableRow key={row.id} style={{cursor:'pointer'}} onClick={() => {this.handleRowClick(row)}}>
                                                <TableCell>
                                                    <img className={classes.thumbnail} src={row.imageUrl} alt="logo"/>
                                                </TableCell>
                                                <TableCell>{row.abbreviation}</TableCell>
                                                <TableCell>{parseFloat(row.rating).toFixed(2)}</TableCell>
                                                <TableCell>{row.name}</TableCell>
                                                <TableCell>{row.capital}</TableCell>
                                            </TableRow>
                                        );
                                    })}

                                </TableBody>
                            </Table>
                        </Paper>
                    </Grid>
                </div>
            );
        }
    }
}

StateTable.propTypes = {
    classes: PropTypes.object.isRequired,
};

export default withStyles(styles)(StateTable);
