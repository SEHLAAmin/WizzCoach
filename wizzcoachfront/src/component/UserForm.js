import React from "react";
import { useForm } from "react-hook-form";
import {withRouter} from "react-router"
import Typography from '@material-ui/core/Typography'
import Button from '@material-ui/core/Button'
import Grid from '@material-ui/core/Grid'
import FormControl from '@material-ui/core/FormControl'
import { Label } from "@material-ui/icons";
import FormLabel from '@material-ui/core/FormLabel'

const UserForm = () => {
  const { register, handleSubmit } = useForm();
  const onSubmit = data => console.log(data);
   
  return (
    <Grid
      container
      spacing={1}
      direction="column"
      justify="center"
      alignItems="center"
      alignContent="center"
      wrap="nowrap"
      
    >
    <Grid item>
      <FormControl onSubmit={handleSubmit(onSubmit)}>
    <Typography variant="h5" color="initial"> remplissez votre formulaire pour pouvoir accéder aux service</Typography>
    
    
  {/* selection genre */}
  <Grid container direction = "column">
    <FormLabel htmlFor="gender">sex</FormLabel>
     
      <select name="gender" ref={register}>
      
        <option value="female">female</option>
        <option value="male">male</option>
        <option value="other">other</option>
      </select>
</Grid>
      {/* selection genre */}

      <label htmlFor="name"   > Name :</label>
      <input type="text" ref={register} placeholder = "Albert"  />

      <label htmlFor="namelastname"   > Last name :</label>
      <input type="text" ref={register} placeholder = "Douvins"  />

      <Grid>
      <label htmlFor="Domaine">Domaine principale</label>
     
     <select name="categorie" ref={register}>
     
       <option value="Cross-fit">Cross-Fit</option>
       <option value="yoga">Yoga</option>
       <option value="autre">Autre</option>
     </select>
      </Grid>
      <Button type="submit" > Envoyer </Button>
    </FormControl>
   </Grid> 
    </Grid>
    
  );
}

export default withRouter(UserForm);