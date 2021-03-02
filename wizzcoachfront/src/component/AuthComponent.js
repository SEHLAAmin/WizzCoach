import React , { useState , useEffect, Fragment} from "react";
import Grid from "@material-ui/core/Grid";
import {
  AmplifySignOut,
  withAuthenticator,
  AmplifySignIn,
} from "@aws-amplify/ui-react";
import CardCate from "./CardCate";
import Auth from "@aws-amplify/auth";
import MenuAppBar from "./MenuAppBar";
import Typography from "@material-ui/core/Typography";
import UserForm from "./UserForm";
import { withRouter } from "react-router";
import { currentUserPoolUser } from "@aws-amplify/auth";
import CoachForm from "./CoachForm";
import Button from '@material-ui/core/Button'
import user from '../App'
import  API  from 'aws-amplify'


const AuthComponent = (props) => {


async function callApi(){
try {
 const peopleData = await API.get('mainapi', '/users')
 console.log('peopleData :' , peopleData)
} catch (err){
console.log(err)
}
}


useEffect(()=> {
  callApi()
}, [])

  const [categorie, setCategorie] = useState(false);

  /*
  const useEffect =()=> {
const handleClickCard = () => {
  props.categoriesName === "Coach" ?
setCategorie({categorie : true}):
console.log(categorie)
}
  }*/
  



  return (

    <Fragment>
      <MenuAppBar />
     
      {
        <Typography variant="h4" component="h4" color="secondary">
         {user && (
           <p>{user.username}</p>
         )}
        </Typography>
      }
      <Grid
        container
        spacing={1}
        direction="row"
        justify="center"
        alignItems="center"
        alignContent="center"
        wrap="nowrap"
        container
        justify="space-around"
      >
        <Grid item  onClick = {()=>setCategorie(true)}  >
          <CardCate categoriesName="Coach"
                    image= "https://static01.nyt.com/images/2020/04/13/sports/12JPvirus-fitnesstrainers1-print/merlin_171442641_661fd6cb-9523-4991-8701-aebdd6a90c82-jumbo.jpg?quality=90&auto=webp"
            />
        </Grid>
        <Grid item  onClick = {()=>setCategorie(false)}>

          <CardCate categoriesName="Lambda"
                    image = "https://www.ifta-fitness.com/cms/wp-content/uploads/00_workout_The-Exercise-High-Is-for-Real%E2%80%94but-Theres-Only-One-Way-to-Get-It_586090217_SG-SHOT.png"
            />
        </Grid>
      </Grid>   
      <div>
      <Button  color="primary" onClick = {()=>setCategorie(!categorie)}>Allez aux Formulaire : { categorie ?  'Utilisateur Lambda' : 'Coach' }</Button>
         {
        categorie ? <CoachForm/> : <UserForm/>
      }
      </div>
    </Fragment>
  );
};
export default withRouter(AuthComponent);
