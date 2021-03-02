import React from "react";
import { makeStyles } from "@material-ui/core";

const useStyles = makeStyles({
  sideBar: {
    marginTop: 4,
    backgroundColor: "#FF7D00",
    left: 8,
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

function SideBar(props) {
  const classes = useStyles(props);
  return <div className={classes.sideBar} boxShadow={3}>
  <h4 className={classes.titlesidebar}>User connected :</h4>
  </div>;
}

export default SideBar;