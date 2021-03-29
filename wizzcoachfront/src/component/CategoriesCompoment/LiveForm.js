import { Label } from '@material-ui/icons'
import React from 'react'
import { withRouter } from 'react-router'
import MenuAppBar from '../MenuAppBar'
import SideBar from '../SideBar'
import {makeStyles, TextField} from '@material-ui//core'

function LiveForm(props) {
    return (
        <div>
<SideBar/>

<div className="conteneurform">

    <h1> Déscriptions du Live </h1>
    <form action="">
   <Label>slt</Label>
    <TextField id="outlined-basic" label="Outlined" variant="outlined" />
    <Label> slt </Label>
    <TextField id="outlined-basic" label="Outlined" variant="outlined" />


    </form>
</div>
        </div>
    )
}
export default withRouter(LiveForm)