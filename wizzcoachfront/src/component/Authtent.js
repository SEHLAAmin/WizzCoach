import React from 'react'
import {Button, FormControlLabel, Input, InputLabel, makeStyles, StylesProvider} from '@material-ui/core'
import { blue, orange } from '@material-ui/core/colors';
import Image from '../img/pexels-li-sun-2294354.jpg'; // Import using relative path
import MenuAppBar from './MenuAppBar';
import { Label, LabelImportantOutlined } from '@material-ui/icons';



const useStyles = makeStyles(() => ({
 
    container : {
        display:'flex',
        flexDirection : 'column',
        width : '100%',
        height : '100%',
        backgroungImage : {Image},    },
barmenu : {
    width : '100%'
}, 
pancarte : {
    display: 'flex',
    flexDirection : 'column',
    position: 'absolute',
    alignContent:'center',
    justifyContent:'center',
    zIndex : '2',
    borderRadius : '20%' , 
    border : 'solid white 2px',
    width: '450px',
    height : '450px',
    backgroundColor : 'grey',
    opacity : '50%',
    margin : '25% 0 75% 35%'
},
imageContainer : {
    
},
pancarteContainer : {
    color : 'black',
    textAlign : 'center'
}

  }));

const handleSubmit =(event)=>{
    event.preventDefault()
    console.log('prout')
}


export default function Authent(props) {

    const classes = useStyles();
      
      
    return (
        <div>
        <div className={classes.container}>
        <MenuAppBar className={classes.barmenu} />
        <div className="imageContainer">
        <img src={Image} height="70%" width="100%" alt=""/></div>
        <div className={classes.pancarte}>
        
        <div className={classes.pancarteContainer}>
           <h1>Identifiez vous:</h1>  
           <form  action="">  <InputLabel>nom :</InputLabel>
                    <Input/>
                    <InputLabel>prenom  :</InputLabel>
                    <Input/>
                    <Button  onSubmit={()=> handleSubmit}  backGroundColor='primary' type = "submit"> Connexion</Button>
                    </form> </div>
        </div>
    </div>
        </div>
    )
}
