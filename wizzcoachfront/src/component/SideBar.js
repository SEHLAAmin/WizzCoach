import React , {useEffect , useState } from "react";
import { makeStyles } from "@material-ui/core";
import arrowLeft from '../img/arrowLeft.png'
import arrowRigths from '../img/arrowRigth.png'
import axios from 'axios'
import avatar from '../img/avatarboy.jpg'
import { Component } from "react";
import zIndex from "@material-ui/core/styles/zIndex";
const useStyles = makeStyles({
  sideBar: {
    borderRadius : '1rem',
    top : '120px',
    backgroundColor: "#FF7D00",
    left: '-95px',
    minWidth: 150,
    height: "80%",
    position: 'fixed',
    zIndex : '1000',
    boxShadow : 3,
    color: (props) => props.color,

    '&:hover': {
      backgroundPosition: '100% 0%',
      left: '5px',
      transition: 'all 1s ease-in-out',
    }


  },

  listuser : {
width:"50%",
listStyle:'none',
fontFamily:'MV Boli',
color : 'white'

  },

  imgPeople : {
  padding : '10px'

  }, 

 titlesidebar: {
        color:'white' , 
        fontFamily : "MV Boli"
  },

  arrowContainer: {
    backgroundColor : '#FF7D00',
    padding : '2px' ,
    marginTop : '10px',
    marginLeft: '75%',
    width : '35px',
    border: ' solid 2px white',
    borderRadius : '10%'
  } , 
  ligthLogged : {
whidth : '100%',
heigth : '100%',
backgroundColor : 'green',
zIndex:'1002',
position :'absolute'
  }
  
});



 
function handleArrow (){

}

function SideBar(props) {
  const [data, setData] = useState({ hits: [] });
  const [sidebar , setSidebar] = useState(null);
  const [arrow , setArrow] = React.useState(false);

  function callData() {
    axios.get('http://localhost:8080/api/v1/user?coach_id=1')
      .then(res => {
        setData({hits : res.data })
        console.log(res);
      })
      .catch(error => {
        // handle error
        console.log(error);
      });
  }
 // fait apelle a la méthode GET 
useEffect ( ()=> {
  callData();
}
 
 , [])

  const classes = useStyles(props);

 
  return <div className={classes.sideBar} boxShadow={3}>
  <button className={classes.arrowContainer}>{
        arrow ?
    <img onClick ={() =>{setArrow(!arrow)}}  className="arrowRigth" src={arrowRigths} />
    :
    <img onClick ={() =>{setArrow(!arrow)}} className="setArrowLeft" src={arrowLeft} alt=""/>


  }
  </button>
  <h4 className={classes.titlesidebar}>User connected :</h4>
  <div>
  <ul className={classes.listuser}>
 {
   data.hits.length == 0 ? "no user connected" : 
   data.hits.map((item) => (
     <li key={item.id}>
       <img 
       className = {classes.imgPeople}
       src={item.avatarUrl} alt=""
         width = "60px"
       />
       <div>{item.pseudo}</div>
     </li>
   ))
 }
    </ul>
    </div>
  </div>;
}

export default SideBar;



