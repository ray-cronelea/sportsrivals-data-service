import React, { Component } from 'react';
import './App.css';
import "typeface-roboto";
import { withStyles } from '@material-ui/core/styles';
import AppBar from '@material-ui/core/AppBar';
import Tabs from '@material-ui/core/Tabs';
import Tab from '@material-ui/core/Tab';
import CircularProgress from "@material-ui/core/CircularProgress/CircularProgress";
import Toolbar from '@material-ui/core/Toolbar';
import Typography from '@material-ui/core/Typography';
import IconButton from '@material-ui/core/IconButton';
import BackIcon from '@material-ui/icons/ArrowBack';
import InfoIcon from '@material-ui/icons/Info';

import RankingTable from './rankingTable';
import SportsTabs from './sportsTabs';

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


    handleChange = (event, value) => {

        this.setState({
            value: value,
            currentSport: this.state.sports[value]
        });
        console.log(value);

    };

    constructor(props) {
        super(props);
        this.state = {
            value: 0,
            isLoaded: false,
            sports: [],
            currentSport: [],
            sportsTabsVisable: false
        };
    }

    componentDidMount() {
        document.title = "Sports Rivals"
        let url = "./api/sports?sort=name";
        console.log("Update Items Url: " + url );

        fetch(url)
            .then(res => res.json())
            .then(
                (result) => {
                    // Examine the text in the response
                    console.log(result);
                    this.setState({
                        isLoaded: true,
                        sports: result._embedded.sports,
                        currentSport: result._embedded.sports[0]
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
        const { value, error, isLoaded, sports, currentSport } = this.state;

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
                <div className="App">

                    <AppBar position="static">
                        <Toolbar>
                            <IconButton className={classes.menuButton} color="inherit" aria-label="Menu">
                                <BackIcon />
                            </IconButton>
                            <Typography variant="h6" color="inherit" className={classes.grow}>
                                Sports Rivals
                            </Typography>
                            <IconButton className={classes.infoButton} color="inherit" aria-label="Menu">
                                <InfoIcon />
                            </IconButton>
                        </Toolbar>

                        <SportsTabs visible={this.state.sportsTabsVisable} />

                        <Tabs centered value={value} onChange={this.handleChange}>
                            {sports.map(row => {
                                return (
                                    <Tab label={row.name} key={row.id}/>
                                );
                            })}
                        </Tabs>
                    </AppBar>

                    <RankingTable visible={this.state.sportsTabsVisable} sport={currentSport}/>

                </div>
            );
        }
    }
}

export default withStyles(styles)(App);
