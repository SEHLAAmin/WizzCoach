import { makeStyles } from '@material-ui/core'
import React , {useState , useEffect} from 'react'
import { withRouter } from 'react-router'
import MenuAppBar from '../MenuAppBar'
import SideBar from '../SideBar'
import GridCate from './GridCate'
import Axios from 'axios-react'

const useStyles = makeStyles((theme) => ({
    cateChooseContainer : {
        border : '1px solid black',
        textAlign : 'center',
        marginTop : '4%',
        width : '60%',
        marginLeft : '30%'
    }
  }));
  




 function ChooseCategorie(props) {


    const classes = useStyles(props);

    return (
        <div>
        <MenuAppBar />
        <SideBar />
        <div className={classes.cateChooseContainer}>
        
        <h2> Choisissez les cours qui vous intéresse le plus ? </h2>
             <GridCate/>
        </div>
           
        </div>
    )
}
export default withRouter(ChooseCategorie);
