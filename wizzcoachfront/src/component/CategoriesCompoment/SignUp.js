import React from 'react'
import {Button, FormControlLabel, FormGroup, Input, InputLabel, makeStyles, StylesProvider, Typography} from '@material-ui/core'
import { blue, orange } from '@material-ui/core/colors';
import MenuAppBar from '../MenuAppBar';
import { Label, LabelImportantOutlined } from '@material-ui/icons';
import {Grid} from '@material-ui/core'
import {Paper} from '@material-ui/core'
import {Avatar, TextField} from '@material-ui/core'
import LockIcon from '@material-ui/icons/Lock';
import {Checkbox} from '@material-ui/core'
import { Link } from '@material-ui/core';
import {withRouter} from 'react-router-dom'

const useStyles = makeStyles(() => ({
 
    all : {
        margin:'0',
        padding : '0'  ,
                width : '100%',
        height :'100%'
    },
    gridcontainer : {
        marginTop : '150px',
        backgroundImage : 'https://1hl88v1pgor71fw4zc37dmbz-wpengine.netdna-ssl.com/wp-content/uploads/background-gym-tablet.jpg',

    }

 
  }));


const handleSubmit =(event)=>{
    event.preventDefault()
}
function SignUp(props) {

    const [data , setData] = React.useState({hits : []})
    const {history} = props  
    const  handleClickSignUp = (URL) =>{
    
    history.push(URL);
      }   
    const classes = useStyles(props);
      const paperStyle = {
          padding  :'20px', height: '80vh' ,width :280, margin :"20px auto"
      }

    const avatarStyle = {
        backgroundColor : 'orange'
    }

    const btnStyle = {
        margin : '10px 0'
    }
      

    return (
        <div>
             <form type="submit" className={classes.all}>
        <div >
        <MenuAppBar />
        </div>

        <Grid className ={classes.gridcontainer}>
            <Paper elevation={10} style={paperStyle}>
                <Grid align='center'> 
            <Avatar style ={avatarStyle}><LockIcon/></Avatar>
            <h2>Sign up</h2>
           </Grid>
            <TextField
              id=""
              label="name"
              placeholder="enter you name"
              fullWidth="true"
              required
            />
            <TextField
              id=""
              label="last name"
              placeholder="enter you last name"
              fullWidth="true"
              required
            />
               <TextField
              id=""
              label="e-mail"
              placeholder="enter you mail"
              fullWidth="true"
              required
            />
             <TextField
              id=""
              label="pseudo"
              placeholder="enter you pseudo"
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
            /><TextField
              id=""
              type="password"
              label=" confirm password"
              placeholder="enter password"
              fullWidth="true"
              required
            />


          
      <Button style={btnStyle} type="submit" color="primary" variant="contained" fullWidth> Sign up </Button>
 
      <Typography>
          Already have an account ?
          <Link onClick = {() => handleClickSignUp('/')}> Sign In </Link>
      </Typography>
            </Paper>
        </Grid>
        </form>
        </div>
    )
    }
export default withRouter(SignUp);