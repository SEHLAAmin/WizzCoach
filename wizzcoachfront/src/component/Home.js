import React, { Component } from 'react'
import { Box, Grid } from '@material-ui/core';
import MenuAppBar from './MenuAppBar';
import CardCate from './CardCate'
import ScopedCssBaseline from '@material-ui/core/ScopedCssBaseline';
import LiveGrid from './LiveGrid';
import Live from './Live';
import { withAuthenticator } from '@aws-amplify/ui-react';





const categories = ["Yoga" , "Muscu" , "Dos"]
const Listcategories = categories.map((categories) => <h2>{categories}</h2>)
const Home = (props) => {
    
    

   

        return (
            <div>
                <MenuAppBar/>

            
      {/*<Cam />*/}
      <h1>Catégorie suivis</h1>

      <Grid
        container
        spacing={1}
        direction="row"
        justify="center"
        alignItems="center"
        alignContent="center"
        wrap="nowrap"
        container
        
      >
      <Grid item>  <CardCate categoriesName ="Yoga"
       image="https://larrogantefr.files.wordpress.com/2019/03/yoga-fertility-charlotte-muller1.jpg?w=1120s" / ></Grid>
      <Grid item>  <CardCate categoriesName ="Muscu"
      image = "https://www.ericfavre.com/lifestyle/wp-content/uploads/2020/06/methode-de-muscu.jpg"
      / ></Grid>
      <Grid item>  <CardCate 
      categoriesName ="Exercice dos"
      image="https://d2z0k43lzfi12d.cloudfront.net/blog/vcdn316/wp-content/uploads/2016/02/thumbnail_6-helpful-exercises_1200x530.jpg" 
          title = "Exo dos"
      />
      </Grid>
      </Grid>
      
     
            <Box marginTop={4} display="flex" justifyContent="center"  > 
            <LiveGrid />
      
            </Box>
          
          
            </div>  
        )
    }
export default withAuthenticator(Home);