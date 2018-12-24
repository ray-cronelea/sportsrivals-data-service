import React, { Component } from 'react';
import './App.css';
import "typeface-roboto";
import { withStyles } from '@material-ui/core/styles';
import AppBar from '@material-ui/core/AppBar';
import Toolbar from '@material-ui/core/Toolbar';
import Typography from '@material-ui/core/Typography';
import IconButton from '@material-ui/core/IconButton';
import MenuIcon from '@material-ui/icons/Menu';
import InfoIcon from '@material-ui/icons/Info';

import SportsPage from './sportsPage';
import LocationsPage from './locationsPage';
import ResultsPage from './resultsPage';
import MenuItem from "@material-ui/core/MenuItem/MenuItem";
import Menu from "@material-ui/core/Menu/Menu";
import Dialog from "@material-ui/core/Dialog/Dialog";
import DialogTitle from "@material-ui/core/DialogTitle/DialogTitle";
import DialogContent from "@material-ui/core/DialogContent/DialogContent";
import DialogActions from "@material-ui/core/DialogActions/DialogActions";
import Button from "@material-ui/core/Button/Button";
import Divider from "@material-ui/core/Divider/Divider";

const styles = theme => ({
    root: {
        flexGrow: 1,
        backgroundColor: theme.palette.background.paper,
    },
    progress: {
        marginTop: "50px",
        margin: theme.spacing.unit * 2,
    },
    grow: {
        flexGrow: 1,
    },
    menuButton: {
        marginLeft: -12,
        marginRight: 20,
    },
    infoButton: {
        marginLeft: 20,
        marginRight: -12,
    },
});

class App extends Component {

    constructor(props) {
        super(props);
        this.state = {
            sportsSelected: true,
            locationsSelected: false,
            resultsSelected: false,
            anchorMenu: null,
            openDialog: false,
        };
    }

    handleMenuClick = event => {
        this.setState({ anchorMenu: event.currentTarget });
    };

    handleMenuClose = () => {
        this.setState({ anchorMenu: null });
    };

    handleInfoClick = event => {
        this.setState({
            openDialog: true,
        });
    }

    handleInfoClose = () => {
        this.setState({ openDialog: false });
    };

    componentDidMount() {
        document.title = "Sports Rivals"
    }

    menuSportsSelected = (e) => {
        this.setState({
            sportsSelected: true,
            locationsSelected: false,
            resultsSelected: false,
        });
        this.handleMenuClose();
    }

    menuLocationsSelected = (e) => {
        this.setState({
            sportsSelected: false,
            locationsSelected: true,
            resultsSelected: false,
        });
        this.handleMenuClose();
    }

    menuResultsSelected = (e) => {
        this.setState({
            sportsSelected: false,
            locationsSelected: false,
            resultsSelected: true,
        });
        this.handleMenuClose();
    }

    render(){
        const { classes } = this.props;
        const { anchorMenu } = this.state;

        return (
            <div className="App">
                <AppBar position="static">
                    <Toolbar>
                        <IconButton aria-owns={anchorMenu ? 'simple-menu' : undefined} aria-haspopup="true" onClick={this.handleMenuClick} className={classes.menuButton} color="inherit" aria-label="Menu">
                            <MenuIcon />
                        </IconButton>
                        <Typography variant="h6" color="inherit" className={classes.grow}>
                            Sports Rivals
                        </Typography>
                        <IconButton className={classes.infoButton} color="inherit" aria-label="Menu" onClick={this.handleInfoClick}>
                            <InfoIcon />
                        </IconButton>
                    </Toolbar>
                </AppBar>

                <SportsPage visible={this.state.sportsSelected}/>
                <LocationsPage visible={this.state.locationsSelected}/>
                <ResultsPage visible={this.state.resultsSelected}/>

                <Menu id="simple-menu" anchorEl={anchorMenu} open={Boolean(anchorMenu)} onClose={this.handleMenuClose}>
                    <MenuItem onClick={this.menuSportsSelected}>Sports</MenuItem>
                    <MenuItem onClick={this.menuLocationsSelected}>Locations</MenuItem>
                    <MenuItem onClick={this.menuResultsSelected}>Results</MenuItem>
                </Menu>


                <Dialog className={classes.dialog} onClose={this.handleInfoClose} aria-labelledby="customized-dialog-title" open={this.state.openDialog}>
                    <DialogTitle id="customized-dialog-title" onClose={this.handleInfoClose}>
                        Sports Rivals
                    </DialogTitle>
                    <Divider />
                    <br/>
                    <DialogContent>
                        <Typography gutterBottom>
                            The goal of this service is to provide a place where rival sports fans can compare the sporting performance of their region
                            versus that of their rivals. They system takes an analytical approach to ranking teams in each particular sport based on the results they obtain in the matches they partake in.
                            An aggregated performance metric is given for all the teams in a particular region.
                            The ranking is generated using the Elo rating system.
                            <br/>
                            <br/>
                            The system takes a distributed micro-service approach to its implementation.
                            Each service has its own specific, isolated task to perform which may be an input to another service in the system.
                            Services are decoupled from one another using AMQP and REST calls over HTTP.
                        </Typography>
                        <br/>
                        <Typography gutterBottom>
                            <b>Course: </b>UCD MSc in Computer Science (Negotiated Learning)
                            <br/>
                            <b>Module: </b>COMP30220 Distributed Computing Module
                            <br/>
                            <b>Developers: </b>Brian Delaney, Ray Wilson
                        </Typography>
                    </DialogContent>
                    <DialogActions>
                        <Button onClick={this.handleInfoClose} color="primary">
                            Close
                        </Button>
                    </DialogActions>
                </Dialog>
            </div>
        );
    }
}

export default withStyles(styles)(App);
