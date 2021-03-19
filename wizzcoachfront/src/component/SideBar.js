import React , {useEffect , useState } from "react";
import { makeStyles } from "@material-ui/core";
import arrowLeft from '../img/arrowLeft.png'
import arrowRigths from '../img/arrowRigth.png'
import axios from 'axios'
import { Component } from "react";
const useStyles = makeStyles({
  sideBar: {
    marginTop: 4,
    backgroundColor: "#FF7D00",
    left: 0,
    minWidth: 150,
    height: "100%",
    paddingBottom: "100%",
    position: "absolute",
    zIndex : 4,
    boxShadow : 3,
    color: (props) => props.color,
  },

 titlesidebar: {
        color:'white' , 
        fontFamily : "MV Boli"
  }
  
});



 
function handleArrow (){

}

function SideBar(props) {
  const [data, setData] = useState({ hits: [] });
  const [sidebar , setSidebar] = useState(null);
  const [arrowRigth , setArrowLeft] = React.useState(false);

 // fait apelle a la méthode GET 
  useEffect(async () => {
    const result = await axios(
      'http://localhost:8080/api/v1/utilisateur',
    );
 
    setData({hits: result.data});
  }, []);
  console.log(data);

  const axios = require('axios');
  const classes = useStyles(props);
  return <div className={classes.sideBar} boxShadow={3}>
  <div className="arrowContainer">{
        arrowRigth ?
    <img onClick ={() =>{setArrowLeft(!arrowRigth)}}  className="arrowRigth" src={arrowRigths} />
    :
    <img onClick ={() =>{setArrowLeft(!arrowRigth)}} className="setArrowLeft" src={arrowLeft} alt=""/>


  }
  </div>
  <h4 className={classes.titlesidebar}>User connected :</h4>
  <div>
  <ul>
 
     
    </ul></div>
  </div>;
}

export default SideBar;