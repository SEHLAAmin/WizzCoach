import { makeStyles } from '@material-ui/core'
import React from 'react'
import { withRouter } from 'react-router'
import MenuAppBar from '../MenuAppBar'
import SideBar from '../SideBar'
import GridCate from './GridCate'


const useStyles = makeStyles((theme) => ({
    cateChooseContainer : {
        border : '1px solid black',
        textAlign : 'center',
        marginTop : '4%',
        width : '50%'
    }
  }));
  

 function ChooseCategorie(props) {

    const classes = useStyles(props);

    return (
        <div>
        <MenuAppBar />
        <SideBar />
        <div className={classes.cateChooseContainer}>
        <h2> Choisissez vos cour de sport qui vous intéresse le plus ? </h2>
             <GridCate/>
        </div>
           
        </div>
    )
}
export default withRouter(ChooseCategorie);
