import React from 'react'
import { withRouter } from 'react-router'
import MenuAppBar from '../MenuAppBar'
import SideBar from '../SideBar';

 function Musculation() {
    return (
        <div>
            <MenuAppBar/>
           <SideBar/> 
            <h1>Musculation Live's :</h1>
        </div>
    )
}


export default withRouter(Musculation);