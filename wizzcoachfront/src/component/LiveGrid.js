import React from 'react';
import { makeStyles } from '@material-ui/core/styles';
import Paper from '@material-ui/core/Paper';
import Grid from '@material-ui/core/Grid';
import Live from './Live'

const useStyles = makeStyles((theme) => ({
  root: {
    flexGrow: 1,
  },
  paper: {
    padding: theme.spacing(2),
    textAlign: 'center',
    color: theme.palette.text.secondary,
  },
}));





export default function LiveGrid() {
  const classes = useStyles();




  return (
    <div className={classes.root}>
      <Grid bgcolor={50} container spacing={3}  direction="column" y={6}>
      <Grid item xs= {8}  >
      <Paper className={classes.paper}> Lives en cour </Paper>

      
      </Grid>
      
      <Live />

      <Grid item xs= {4}  >
      <Paper className={classes.paper}> Lives en cour </Paper>
    
      </Grid>
      </Grid>
    </div>
  );
}