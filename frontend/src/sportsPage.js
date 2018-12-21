import React, { Component } from 'react';
import './App.css';
import "typeface-roboto";
import { withStyles } from '@material-ui/core/styles';

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

class SportsPage extends Component {


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
            currentSport: [],
        };
    }

    updateCurrentSport = (sport) => {
        if (sport) {
            this.setState({currentSport: sport})
        } else {
            this.setState({currentSport: []})
        }
    }

    componentDidMount() {

    }

    render() {
        const { currentSport } = this.state;

        if (!this.props.visible){
            return null;
        } else {
            return (
                <div className="SportsPage">
                    <SportsTabs visible={true} updateCurrentSport={this.updateCurrentSport} currentSport={this.state.currentSport}/>
                    <RankingTable visible={true} sport={currentSport}/>
                </div>
            );
        }
    }
}

export default withStyles(styles)(SportsPage);
