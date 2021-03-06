import React, { Component } from 'react';
import './App.css';
import "typeface-roboto";
import { withStyles } from '@material-ui/core/styles';
import Tabs from '@material-ui/core/Tabs';
import Tab from '@material-ui/core/Tab';
import CircularProgress from "@material-ui/core/CircularProgress/CircularProgress";

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

class SportsTabs extends Component {


    handleChange = (event, value) => {
        this.setState({
            value: value,
            currentSport: this.state.sports[value]
        });
        this.props.updateCurrentSport(this.state.sports[value]);
        console.log(value);
    };

    constructor(props) {
        super(props);
        this.state = {
            value: 0,
            isLoaded: false,
            sports: [],
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
                    this.props.updateCurrentSport(result._embedded.sports[0]);
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
        const { value, error, isLoaded, sports } = this.state;

        if (!this.props.visible){
            return null;
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
                <div className="App">
                    <Tabs centered value={value} onChange={this.handleChange}>
                        {sports.map(row => {
                            return (
                                <Tab label={row.name} key={row.id}/>
                            );
                        })}
                    </Tabs>
                </div>
            );
        }
    }
}

export default withStyles(styles)(SportsTabs);
