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
import TableFooter from "@material-ui/core/TableFooter/TableFooter";
import TablePagination from "@material-ui/core/TablePagination/TablePagination";
import IconButton from "@material-ui/core/IconButton/IconButton";
import KeyboardArrowRight from "@material-ui/core/es/internal/svg-icons/KeyboardArrowRight";
import KeyboardArrowLeft from "@material-ui/core/es/internal/svg-icons/KeyboardArrowLeft";
import LastPageIcon from '@material-ui/icons/LastPage';
import FirstPageIcon from '@material-ui/icons/FirstPage';



const actionsStyles = theme => ({
    root: {
        flexShrink: 0,
        color: theme.palette.text.secondary,
        marginLeft: theme.spacing.unit * 2.5,
    },
});

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
    thumbnailSpace: {
        width: '40px'
    },
    rowScore: {
        minWidth: '100px',
        textAlign: 'center',
        padding: '4px 5px 4px 5px'
    },
    thumbnail: {
        width: "100%"
    },
    progress: {
        marginTop: "50px",
        margin: theme.spacing.unit * 2,
        marginLeft: '50%',
        left: '-20'
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
});

class TablePaginationActions extends React.Component {
    handleFirstPageButtonClick = event => {
        this.props.onChangePage(event, 0);
    };

    handleBackButtonClick = event => {
        this.props.onChangePage(event, this.props.page - 1);
    };

    handleNextButtonClick = event => {
        this.props.onChangePage(event, this.props.page + 1);
    };

    handleLastPageButtonClick = event => {
        this.props.onChangePage(
            event,
            Math.max(0, Math.ceil(this.props.count / this.props.rowsPerPage) - 1),
        );
    };

    render() {
        const { classes, count, page, rowsPerPage, theme } = this.props;

        return (
            <div className={classes.root}>
                <IconButton
                    onClick={this.handleFirstPageButtonClick}
                    disabled={page === 0}
                    aria-label="First Page"
                >
                    {theme.direction === 'rtl' ? <LastPageIcon /> : <FirstPageIcon />}
                </IconButton>
                <IconButton
                    onClick={this.handleBackButtonClick}
                    disabled={page === 0}
                    aria-label="Previous Page"
                >
                    {theme.direction === 'rtl' ? <KeyboardArrowRight /> : <KeyboardArrowLeft />}
                </IconButton>
                <IconButton
                    onClick={this.handleNextButtonClick}
                    disabled={page >= Math.ceil(count / rowsPerPage) - 1}
                    aria-label="Next Page"
                >
                    {theme.direction === 'rtl' ? <KeyboardArrowLeft /> : <KeyboardArrowRight />}
                </IconButton>
                <IconButton
                    onClick={this.handleLastPageButtonClick}
                    disabled={page >= Math.ceil(count / rowsPerPage) - 1}
                    aria-label="Last Page"
                >
                    {theme.direction === 'rtl' ? <FirstPageIcon /> : <LastPageIcon />}
                </IconButton>
            </div>
        );
    }
}

TablePaginationActions.propTypes = {
    classes: PropTypes.object.isRequired,
    count: PropTypes.number.isRequired,
    onChangePage: PropTypes.func.isRequired,
    page: PropTypes.number.isRequired,
    rowsPerPage: PropTypes.number.isRequired,
    theme: PropTypes.object.isRequired,
};

const TablePaginationActionsWrapped = withStyles(actionsStyles, { withTheme: true })(
    TablePaginationActions,
);

class StateTable extends React.Component{
    constructor(props) {
        super(props);
        this.state = {
            isLoaded: false,
            data: [],
            page: 0,
            rowsPerPage: 20,
            dataLength: 0,
        };
    }

    componentDidMount() {
        this.getRankingsForSport();
    }

    handleChangePage = (event, page) => {
        this.setState({ page });
    };

    handleChangeRowsPerPage = event => {
        this.setState({
            rowsPerPage: Number.parseInt(event.target.value),
            page: 0,
        });
    };

    componentDidUpdate(prevProps, prevState, snapshot) {
        if (prevState.page !== this.state.page) {
            this.getRankingsForSport();
        } else if (prevState.rowsPerPage !== this.state.rowsPerPage){
            this.getRankingsForSport();
        }
    }

    getRankingsForSport() {
        let size = this.state.rowsPerPage;
        let page = this.state.page;
        let url = './api/fixtures?size=' + size + '&sort=kickOffTime,desc&page=' + page;

        this.setState({
            isLoaded: false,
            data: [],
        });

        fetch(url)
            .then(res => res.json())
            .then(
                (result) => {
                    console.log(result._embedded.fixtures);
                    this.setState({
                        isLoaded: true,
                        data: result._embedded.fixtures,
                        dataLength: result.page.totalElements,
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

    handleRowClick = (data) => {
        console.log(data.name);
        this.setState({
        });
    }

    render() {
        const { classes } = this.props;
        const { error, isLoaded, data, rowsPerPage, page, dataLength} = this.state;
        const emptyRows = rowsPerPage - Math.min(rowsPerPage, dataLength - page * rowsPerPage);

        if (! this.props.visible){
            return null
        } else if (error) {
            return <div>Error: {error.message}</div>;
        } else {
            return (
                <div>
                    <Grid container justify = "center">
                        <Paper className={classes.root}>
                            <Table className={classes.table}>
                                <TableHead>
                                    <TableRow>
                                        <TableCell className={classes.rowScore}>Kick Off Time</TableCell>
                                        <TableCell className={classes.thumbnailSpace}></TableCell>
                                        <TableCell className={classes.rowScore}>Home Team</TableCell>
                                        <TableCell className={classes.rowScore}>Score</TableCell>
                                        <TableCell className={classes.rowScore}>Away Team</TableCell>
                                        <TableCell className={classes.thumbnailSpace}></TableCell>
                                    </TableRow>
                                </TableHead>

                                <TableBody>

                                    {!isLoaded && (
                                        <TableRow style={{ height: 52 * rowsPerPage }}>
                                            <TableCell colSpan={6}><CircularProgress className={classes.progress}/></TableCell>
                                        </TableRow>
                                    )}

                                    {data.map(row => {
                                        return (
                                            <TableRow key={row.id} style={{cursor:'pointer'}} onClick={() => {this.handleRowClick(row)}}>
                                                <TableCell className={classes.rowScore}>{new Date(row.kickOffTime).toLocaleDateString() + " " + new Date(row.kickOffTime).toLocaleTimeString() }</TableCell>
                                                <TableCell>
                                                    <img className={classes.thumbnailSpace} src={row.homeTeam.imageUrl} alt="logo"/>
                                                </TableCell>
                                                <TableCell className={classes.rowScore}>{row.homeTeam.name}</TableCell>
                                                <TableCell className={classes.rowScore}>{row.homeTeamScore + " - " + row.awayTeamScore}</TableCell>
                                                <TableCell className={classes.rowScore}>{row.awayTeam.name}</TableCell>
                                                <TableCell>
                                                    <img className={classes.thumbnailSpace} src={row.awayTeam.imageUrl} alt="logo"/>
                                                </TableCell>
                                            </TableRow>
                                        );
                                    })}

                                    {emptyRows > 0 && isLoaded && (
                                        <TableRow style={{ height: 52 * emptyRows }}>
                                            <TableCell colSpan={6} />
                                        </TableRow>
                                    )}
                                </TableBody>
                                <TableFooter>
                                    <TableRow>
                                        <TablePagination
                                            rowsPerPageOptions={[10, 20, 30]}
                                            colSpan={3}
                                            count={dataLength}
                                            rowsPerPage={rowsPerPage}
                                            page={page}
                                            SelectProps={{
                                                native: true,
                                            }}
                                            onChangePage={this.handleChangePage}
                                            onChangeRowsPerPage={this.handleChangeRowsPerPage}
                                            ActionsComponent={TablePaginationActionsWrapped}
                                        />
                                    </TableRow>
                                </TableFooter>
                            </Table>
                        </Paper>
                    </Grid>
                </div>
            );
        }
    }
}

StateTable.propTypes = {
    classes: PropTypes.object.isRequired,
};

export default withStyles(styles)(StateTable);
