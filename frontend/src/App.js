import React, { Component } from 'react';
import './App.css';
import "typeface-roboto";
import { withStyles } from '@material-ui/core/styles';
import AppBar from '@material-ui/core/AppBar';
import Tabs from '@material-ui/core/Tabs';
import Tab from '@material-ui/core/Tab';
import RankingTable from './rankingTable';
import CircularProgress from "@material-ui/core/CircularProgress/CircularProgress";

const styles = theme => ({
    root: {
        flexGrow: 1,
        backgroundColor: theme.palette.background.paper,
    },
});

class App extends Component {


    handleChange = (event, value) => {
        this.setState({ value });

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
            currentSport: []
        };
    }

    componentDidMount() {
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
                        <Tabs centered value={value} onChange={this.handleChange}>
                            {sports.map(row => {
                                return (
                                    <Tab label={row.name} key={row.id}/>
                                );
                            })}
                        </Tabs>
                    </AppBar>

                    <RankingTable sport={currentSport}/>

                </div>
            );
        }
    }
}

export default withStyles(styles)(App);
