import React from 'react'
import {Button, makeStyles} from '@material-ui/core'
const useStyles = makeStyles({
 button: {position : 'fixed',
 zIndex : '100',
 bottom : '15px',
 width : '200px',
 right : '20px',
 padding : '20px',
 backgroundColor : '#FF7D00',
 borderRadius : '2rem',
 color: 'white',
 fontFamily : 'MV BOli',
     "&:hover" : {
         cursor : 'pointer',
         backgroundColor : '#E8550C'
     }

}});


export default function ButtonDustream(props) {
    const classes = useStyles(props);
    return (
        <Button className = {classes.button} onCLick ={props.handleClickCard}>
Lancez Stream  
        </Button>
    )
}