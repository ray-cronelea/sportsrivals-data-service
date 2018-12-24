import React, { Component } from 'react';
import './App.css';
import "typeface-roboto";
import { withStyles } from '@material-ui/core/styles';

import ResultsTable from './resultsTable';

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
        });
        console.log(value);
    };

    constructor(props) {
        super(props);
        this.state = {
        };
    }

    componentDidMount() {

    }

    render() {

        if (!this.props.visible){
            return null;
        } else {
            return (
                <div>
                    <ResultsTable visible={true}/>
                </div>
            );
        }
    }
}

export default withStyles(styles)(SportsPage);
