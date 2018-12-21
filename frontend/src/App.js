import React, { Component } from 'react';
import './App.css';
import "typeface-roboto";
import RankingTable from './rankingTable';

class App extends Component {
    render() {
        return (
        <div className="App">

            <RankingTable />

        </div>
        );
    }
}

export default App;
