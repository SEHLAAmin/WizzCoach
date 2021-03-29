import React from 'react'
import {Button, FormControlLabel, Input, InputLabel, makeStyles, StylesProvider, Typography} from '@material-ui/core'
import { blue, orange } from '@material-ui/core/colors';
import Image from '../img/pexels-li-sun-2294354.jpg'; // Import using relative path
import MenuAppBar from './MenuAppBar';
import { Label, LabelImportantOutlined } from '@material-ui/icons';
import {Grid} from '@material-ui/core'
import {Paper} from '@material-ui/core'
import {Avatar, TextField} from '@material-ui/core'
import LockIcon from '@material-ui/icons/Lock';
import {Checkbox} from '@material-ui/core'
import { Link } from '@material-ui/core';


const useStyles = makeStyles(() => ({
 
    all : {
        margin:'0',
        padding : '0'  ,
        backgroundImage : 'https://1hl88v1pgor71fw4zc37dmbz-wpengine.netdna-ssl.com/wp-content/uploads/background-gym-tablet.jpg',
        width : '100%',
        height :'100%'
    },
    gridcontainer : {
        marginTop : '150px'
    }

 
  }));


const handleSubmit =(event)=>{
    event.preventDefault()
}



export default function Authent(props) {
  
    const {history} = props  
    const  handleClickSignUp = (URL) =>{
    
    history.push(URL);
      }   
    const classes = useStyles(props);
      const paperStyle = {
          padding  :'20px', height: '70vh' ,width :280, margin :"20px auto"
      }

    const avatarStyle = {
        backgroundColor : 'orange'
    }

    const btnStyle = {
        margin : '10px 0'
    }
      


    return (
        <div className={classes.all}>
        <div >
        <MenuAppBar />
        </div>

        <Grid className ={classes.gridcontainer}>
            <Paper elevation={10} style={paperStyle}>
                <Grid align='center'> 
            <Avatar style ={avatarStyle}><LockIcon/></Avatar>
            <h2>Sign in</h2>
           </Grid>
            <TextField
              id=""
              label="pseudo/mail"
              placeholder="enter pseudo/mail"
              fullWidth="true"
              required
            />
               <TextField
              id=""
              type="password"
              label="password"
              placeholder="enter password"
              fullWidth="true"
              required
            />
            <FormControlLabel
        control={
          <Checkbox
    
            name="checkedB"
            color="primary"
          />
        }
        label="Remember-me"
      />
      <Button style={btnStyle} type="submit" color="primary" variant="contained" fullWidth> Sign in </Button>
      <Typography>
      <Link href="#" >
          forgot password ?
      </Link>
      </Typography>
      <Typography>
          Do you have an account ?
          <Link onClick = {() => handleClickSignUp('/home')}> Sign Up </Link>
      </Typography>
            </Paper>
        </Grid>
        </div>
    )
}
