import { Label } from '@material-ui/icons'
import React from 'react'
import { withRouter } from 'react-router'
import MenuAppBar from '../MenuAppBar'
import SideBar from '../SideBar'
import {Button, FormControl, InputLabel, makeStyles, Paper, TextField} from '@material-ui//core'


const useStyles = makeStyles((theme) => ({
 conteneurForm: {
backgroundColor : '#E9E9E9',
border : 'solid grey 2px',
borderRadius : '2rem',
width : '18rem',
height : '28rem',
margin : '25%',
alignItems : 'center',
textAlign : 'center',
display : 'flex',
flexDirection : 'column' , 
color : 'grey'

 } , 
 btnDuSubmit : {
backgroundColor : '#FF7D00',
margin : '20%' 
 }
}));



function LiveForm(props) {

    const [formData, updateFormData] = React.useState([]);
    const classes = useStyles();
    const axios = require("axios");
    const coachId = 1;

    const dataSend = {
        title: formData.title,
        description : formData.description,
    }
    const handleChange = (event) => {
        updateFormData({
          ...formData,
    
          [event.target.name]: event.target.value.trim(),
        });
        console.log(formData);
    }

    const handleSubmit  =(event)=>{
        event.preventDefault();
           axios.post('http://localhost:8080/api/v1/lives/1/coachpost', {
           dataSend
          })
          .then(res => {
            console.log(res);
          }, (error) => {
            console.log(error);
          });
    }

    return (
        <div>
        <MenuAppBar /> 
        <SideBar/>

<Paper className={classes.conteneurForm}>

    <h1> Remplissez le formulaire </h1>
    
    <FormControl onChange={handleChange}>
    <TextField
              id=""
              label="Titre du live "
              placeholder=""
              fullWidth="true"
              required
              name = "title"
            />
            <TextField
            name ="description"
              id=""
              label="Déscription du live"
              placeholder=""
              fullWidth="true"
              required
              multiline ='true'
              rowsMax="12"
            />
             

        <Button onClick={handleSubmit} className={classes.btnDuSubmit}>  Submit </Button>

    </FormControl>
</Paper>
        </div>
    )
}
export default withRouter(LiveForm)