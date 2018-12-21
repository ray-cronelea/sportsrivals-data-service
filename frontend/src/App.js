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
            citiesSelected: false,
            statesSelected: false,
        };
    }

    componentDidMount() {
        document.title = "Sports Rivals"
    }

    render(){
        const { classes } = this.props;
        const { sportsSelected } = this.state;

        return (
            <div className="App">
                <AppBar position="static">
                    <Toolbar>
                        <IconButton className={classes.menuButton} color="inherit" aria-label="Menu">
                            <MenuIcon />
                        </IconButton>
                        <Typography variant="h6" color="inherit" className={classes.grow}>
                            Sports Rivals
                        </Typography>
                        <IconButton className={classes.infoButton} color="inherit" aria-label="Menu">
                            <InfoIcon />
                        </IconButton>
                    </Toolbar>
                </AppBar>

                <SportsPage visible={sportsSelected}/>

            </div>
        );
    }

}

export default withStyles(styles)(App);
