import React, { Component } from 'react'
import { Box } from '@material-ui/core';
import MenuAppBar from './MenuAppBar';
import CardCate from './CardCate'
import ScopedCssBaseline from '@material-ui/core/ScopedCssBaseline';
import LiveGrid from './LiveGrid';
import Live from './Live';





const categories = ["Yoga" , "Muscu" , "Dos"]
const Listcategories = categories.map((categories) => <h2>{categories}</h2>)
export default class Home extends Component {
    
    

    render() {

        return (
            <div>
                <MenuAppBar/>

            
      {/*<Cam />*/}
      <h1>Catégorie suivis</h1>
      <Box display="flex" justifyContent="center" > 
            <CardCate categories ="Yoga" / >
            <CardCate categories = "Muscu" />
            <CardCate categories = "Exercice Dos" />
              </Box>

            <Box marginTop={4} display="flex" justifyContent="center"  > 
            <LiveGrid />
      
            </Box>
          
          
            </div>  
        )
    }
}
