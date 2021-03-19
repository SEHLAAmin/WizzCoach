import React from 'react'
import { withRouter } from 'react-router'
import MenuAppBar from '../MenuAppBar'
import SideBar from '../SideBar';

 function Yoga() {
    return (
        <div>
            <MenuAppBar/>
           <SideBar/> 
            <h1>Yoga Live's :</h1>
        </div>
    )
}


export default withRouter(Yoga);