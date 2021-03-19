import React from 'react'
import {makeStyles} from '@material-ui/core'
const useStyles = makeStyles({
 button: {position : 'fixed',
 zIndex : '100',
 bottom : '15px',
 width : '200px',
 right : '20px',
 padding : '20px',
 backgroundColor : '#FF7D00',
 borderRadius : '5%',
 boxShadow : '0 12px 20px 5px black',
 color: 'white',
 fontFamily : 'MV BOli',
 webkitBoxShadow:'21px 23px 5px 22px rgba(156,156,156,1)',
mozBoxShadow: '21px 23px 5px 22px rgba(156,156,156,1)',
boxShadow:'21px 23px 5px 22px rgba(156,156,156,1)' , 
     "&:hover" : {
         cursor : 'pointer',
         backgroundColor : '#E8550C'
     }

}});


export default function ButtonDustream(props) {
    const classes = useStyles(props);
    return (
        <button className = {classes.button}>
Lancez Stream  
        </button>
    )
}