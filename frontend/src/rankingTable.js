import React from 'react';
import PropTypes from 'prop-types';
import { withStyles } from '@material-ui/core/styles';
import CardContent from "@material-ui/core/CardContent/CardContent";
import Typography from "@material-ui/core/Typography/Typography";
import Card from "@material-ui/core/Card/Card";
import Table from "@material-ui/core/Table/Table";
import TableHead from "@material-ui/core/TableHead/TableHead";
import TableRow from "@material-ui/core/TableRow/TableRow";
import TableCell from "@material-ui/core/TableCell/TableCell";
import TableBody from "@material-ui/core/TableBody/TableBody";
import Checkbox from "@material-ui/core/Checkbox/Checkbox";
import Paper from "@material-ui/core/Paper/Paper";
import Grid from "@material-ui/core/Grid/Grid";


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
    }
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
        let url = './api/teams/search/findBySport?id=5c1c2b4668b7a0f9f10374ad';

        console.log("Update Items Url: " + url );

        fetch(url)
            .then(res => res.json())
            .then(
                (result) => {
                    // Examine the text in the response
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
        {/*this.props.setReload(false);*/}
    }

    render() {
        const { classes } = this.props;
        const { error, isLoaded, items } = this.state;
        if (error) {
            return <div>Error: {error.message}</div>;
        } else if (!isLoaded) {
            return <div>Loading...</div>;
        } else {
            return (
                <Grid container justify = "center">
                    <Paper className={classes.root}>
                        <Card className={classes.card}>
                            <CardContent>
                                <Typography variant="h5" component="h2">Sports Rivals NFL Team Rankings</Typography>
                            </CardContent>
                        </Card>

                        <Table className={classes.table}>
                            <TableHead>
                                <TableRow>
                                    <TableCell className={classes.tabbutton}>Done</TableCell>
                                    <TableCell>Name</TableCell>
                                    <TableCell>Ranking</TableCell>
                                    <TableCell>Sport</TableCell>
                                    <TableCell>City</TableCell>
                                    <TableCell>State</TableCell>
                                </TableRow>
                            </TableHead>


                            <TableBody>

                                {this.state.data.teams.map(row => {
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
