import React from 'react';
import { makeStyles } from '@material-ui/core/styles';
import Card from '@material-ui/core/Card';
import CardActionArea from '@material-ui/core/CardActionArea';
import CardActions from '@material-ui/core/CardActions';
import CardContent from '@material-ui/core/CardContent';
import CardMedia from '@material-ui/core/CardMedia';
import Button from '@material-ui/core/Button';
import Typography from '@material-ui/core/Typography';

const useStyles = makeStyles({
  cardroot: {
    maxWidth: 345,
  },
  media: {
    height: 140,
  },
});



/*
function CategoriesList(props) {
  const categories = props.categories;
  const listCate = categories.map((categories) =>    <Typography>{categories}</Typography>  );  
  return (
    <Typography>{listCate}</Typography>  );
}


const categories = ["Yoga" , "Muscu" , "Dos"]
const Listcategories = categories.map((categories) => <h2>{categ*/

const CardCate = (props) =>{
  const classes = useStyles();

  const handleClickCard = (e) => {
    e.preventDefault();
    console.log('Bienvenue');

  }

  return (
    <Card className={classes.cardroot} >
      <CardActionArea>
        <CardMedia
          className={classes.media}
          src="https://wallpapercart.com/wp-content/uploads/2019/09/fitness-models-female-wallpaper.jpg"
          title="Contemplative Reptile"
        />
        <CardContent>
          <Typography gutterBottom variant="h5" component="h2">{props.categories}
          </Typography>
          <Typography variant="body2" color="textSecondary" component="p">
            Lorem ipsum dolor sit amet consectetur adipisicing elit. Asperiores magnam nihil eos dolor fugiat? Reiciendis quidem provident nesciunt repellendus sed explicabo maxime earum, repellat quo. Iure nisi necessitatibus debitis quasi?
          </Typography>
        </CardContent>
      </CardActionArea>
      <CardActions>
        <Button size="small" color="primary" onClick={()=> handleClickCard}>
          Joins us !
        </Button>
        <Button size="small" color="primary">
          Learn More
        </Button>
      </CardActions>
    </Card>
  );
}
export default CardCate;