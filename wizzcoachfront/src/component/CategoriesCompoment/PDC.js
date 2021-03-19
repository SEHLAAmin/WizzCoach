import React from 'react'
import { withRouter } from 'react-router'
import MenuAppBar from '../MenuAppBar'
import SideBar from '../SideBar';

 function PDC() {
    return (
        <div>
            <MenuAppBar/>
           <SideBar/> 
            <h1>PDC Live's :</h1>
        </div>
    )
}


export default withRouter(PDC);