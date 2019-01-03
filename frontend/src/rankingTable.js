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
import DialogTitle from "@material-ui/core/DialogTitle/DialogTitle";
import Dialog from "@material-ui/core/Dialog/Dialog";
import DialogContent from "@material-ui/core/DialogContent/DialogContent";
import DialogActions from "@material-ui/core/DialogActions/DialogActions";
import Button from "@material-ui/core/Button/Button";
import Typography from "@material-ui/core/Typography/Typography";

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
    dialogImage: {
        width: 128,
        height: 128,
    },
    dialogImg: {
        margin: 'auto',
        display: 'block',
        maxWidth: '100%',
        maxHeight: '100%',
        align: 'center',
    },
    brBorder: {
        borderBottom: `1px solid ${theme.palette.divider}`,
    },
});


class RankingTable extends React.Component{
    constructor(props) {
        super(props);
        this.state = {
            isLoaded: false,
            data: [],
            selectedTeam: [],
            selectedSport: [],
            selectedCity: [],
            selectedState: [],
            open: false
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

    handleRowClick = (team) => {
        console.log(team.name);
        this.setState({
            selectedTeam: team,
            selectedSport: team.sport,
            selectedCity: team.city,
            selectedState: team.state,
        });
        this.handleClickOpen();
    }

    handleClickOpen = () => {
        this.setState({
            open: true,
        });
    };

    handleClose = () => {
        this.setState({ open: false });
    };

    render() {
        const { classes } = this.props;
        const { error, isLoaded, data, selectedTeam, selectedSport, selectedState, selectedCity } = this.state;
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
                                    <TableCell>Sport</TableCell>
                                    <TableCell>City</TableCell>
                                    <TableCell>State</TableCell>
                                </TableRow>
                            </TableHead>


                            <TableBody>

                                {data.teams.map(row => {
                                    return (
                                        <TableRow key={row.id} style={{cursor:'pointer'}} onClick={() => {this.handleRowClick(row)}}>
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

                <Dialog onClose={this.handleClose} aria-labelledby="customized-dialog-title" open={this.state.open}>
                    <DialogTitle id="customized-dialog-title" onClose={this.handleClose} style={{textAlign:'center'}}>{selectedTeam.name}</DialogTitle>
                        <DialogContent className={classes.card}>

                            <Grid container spacing={16} alignItems="center" justify="center">
                                <Grid item >
                                    <Grid className={classes.dialogImage}>
                                        <img className={classes.dialogImg} alt="complex" src={selectedTeam.imageUrl} />
                                    </Grid>
                                </Grid>
                                <Grid item xs={12} sm container>
                                    <Grid item xs container direction="column" spacing={16} style={{width:'150px'}}>

                                        <Grid item xs>
                                            <Typography gutterBottom style={{textAlign: 'center'}}>
                                                Sport: {selectedSport.sportName}
                                            </Typography>
                                            <Typography gutterBottom className={classes.brBorder}  style={{textAlign: 'center'}}>
                                                Ranking: {parseFloat(selectedTeam.rating).toFixed(2)}
                                            </Typography>
                                            <Typography gutterBottom style={{textAlign: 'center'}}>
                                                City: {selectedCity.name}
                                            </Typography>
                                            <Typography gutterBottom className={classes.brBorder} style={{textAlign: 'center'}}>
                                                Ranking: {parseFloat(selectedCity.rating).toFixed(2)}
                                            </Typography>
                                            <Typography gutterBottom style={{textAlign: 'center'}}>
                                                State: {selectedState.abbreviation}
                                            </Typography>
                                            <Typography gutterBottom style={{textAlign: 'center'}}>
                                                Ranking: {parseFloat(selectedState.rating).toFixed(2)}
                                            </Typography>
                                        </Grid>

                                    </Grid>
                                </Grid>
                            </Grid>

                        </DialogContent>
                        <DialogActions>
                        <Button onClick={this.handleClose} color="primary">Close</Button>
                    </DialogActions>
                </Dialog>

                </div>
            );
        }
    }
}

RankingTable.propTypes = {
    classes: PropTypes.object.isRequired,
};

export default withStyles(styles)(RankingTable);
