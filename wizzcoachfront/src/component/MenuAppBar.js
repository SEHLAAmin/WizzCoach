import React from 'react';
import { makeStyles } from '@material-ui/core/styles';
import AppBar from '@material-ui/core/AppBar';
import Toolbar from '@material-ui/core/Toolbar';
import Typography from '@material-ui/core/Typography';
import IconButton from '@material-ui/core/IconButton';
import MenuIcon from '@material-ui/icons/Menu';
import AccountCircle from '@material-ui/icons/AccountCircle';
import Switch from '@material-ui/core/Switch';
import FormControlLabel from '@material-ui/core/FormControlLabel';
import FormGroup from '@material-ui/core/FormGroup';
import MenuItem from '@material-ui/core/MenuItem';
import Menu from '@material-ui/core/Menu';
import {withRouter} from 'react-router-dom'
import { palette } from '@material-ui/system';
import AmplifysSignOut from '@aws-amplify/auth'
import Auth from '@aws-amplify/auth'


const useStyles = makeStyles((theme) => ({
  root: {
    flexGrow: 1,
  },
  menuButton: {
    marginRight: theme.spacing(2),
  },
  title: {
    flexGrow: 1,
    fontFamily : 'MV Boli ',
    color : 'white',
    cursor : 'pointer' ,
    fontWeight: ''
  },
}));

const MenuAppBar = props => {
  
 /* console.log(props);*/
  const classes = useStyles();
  const [auth, setAuth] = React.useState(Auth);
  const [anchorEl, setAnchorEl] = React.useState(null);
  const open = Boolean(anchorEl);
  const {history } = props;
  const handleChange = (event) => {
    setAuth(event.target.checked);
  };

  const handleMenu = (event) => {
    setAnchorEl(event.currentTarget);
  };

  const handleMenuClick = (pageURL) => {
    history.push(pageURL);
    setAnchorEl(null);
  };
  async function signOut(pageURL) {

    try {
        await Auth.signOut();
    } catch (error) {
        console.log('error signing out: ', error);
    } history.push(pageURL);
};
async function signIn() {
  try {
      const user = await Auth.currentAuthenticatedUser(this.state.username, this.state.user.password);
  } catch (error) {
      console.log('error signing in', error);

  }
}

  return (
    <div className={classes.root}>
      <FormGroup>
        <FormControlLabel
          control={<Switch  onChange={handleChange} aria-label="login switch" />}
          label={auth ? 'Logout' : 'Login'}
        />
      </FormGroup>
      <AppBar position="static" color= "primary">
        <Toolbar>
      
          <Typography  variant="h6" className={classes.title} onClick={()=> handleMenuClick('/')} > <a href=""></a>
            WizzCoach
          </Typography>
          {auth && (
            <div>
              <IconButton
                aria-label="account of current user"
                aria-controls="menu-appbar"
                aria-haspopup="true"
                onClick={handleMenu}
                color="inherit"
              >
                <AccountCircle />
              </IconButton>
              <Menu
                id="menu-appbar"
                anchorEl={anchorEl}
                anchorOrigin={{
                  vertical: 'top',
                  horizontal: 'right',
                }}
                keepMounted
                transformOrigin={{
                  vertical: 'top',
                  horizontal: 'right',
                }}
                open={open}
                onClose={() => 
                setAnchorEl(null)}
              >
              
                <MenuItem onClick={()=> handleMenuClick('/auth')}>Profile</MenuItem>
                <MenuItem onClick={()=> handleMenuClick('/')}>Home</MenuItem>
                <MenuItem onClick={()=> signOut('/auth')}>Deconnection</MenuItem>

              </Menu>
            </div>
          )}
        </Toolbar>
      </AppBar>
    </div>
  );
}
export default withRouter(MenuAppBar);