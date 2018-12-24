import React, { Component } from 'react';
import './App.css';
import "typeface-roboto";
import { withStyles } from '@material-ui/core/styles';
import Tabs from "@material-ui/core/Tabs/Tabs";
import Tab from "@material-ui/core/Tab/Tab";

import StateTable from './stateTable';
import CityTable from './cityTable';

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

        if (value === 0){
            console.log("Opening city page");
            this.setState({
                value: value,
                citySelected: false,
                stateSelected: true,
            });
        } else {
            console.log("Opening state page");
            this.setState({
                value: value,
                citySelected: true,
                stateSelected: false,
            });
        }
    };

    constructor(props) {
        super(props);
        this.state = {
            value: 0,
            citySelected: false,
            stateSelected: true,
        };
    }

    componentDidMount() {}

    render() {
        const { value } = this.state;

        if (!this.props.visible){
            return null;
        } else {
            return (
                <div className="SportsPage">
                    <div className="App">
                        <Tabs centered value={value} onChange={this.handleChange}>
                            <Tab label="State" key="0"/>
                            <Tab label="city" key="1"/>
                        </Tabs>
                    </div>


                    <StateTable visible={this.state.stateSelected}/>
                    <CityTable visible={this.state.citySelected}/>

                </div>
            );
        }
    }
}

export default withStyles(styles)(SportsPage);
