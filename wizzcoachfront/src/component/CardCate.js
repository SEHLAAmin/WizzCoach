import React from "react";
import { makeStyles } from "@material-ui/core/styles";
import Card from "@material-ui/core/Card";
import CardActionArea from "@material-ui/core/CardActionArea";
import CardActions from "@material-ui/core/CardActions";
import CardContent from "@material-ui/core/CardContent";
import CardMedia from "@material-ui/core/CardMedia";
import Button from "@material-ui/core/Button";
import Typography from "@material-ui/core/Typography";
import CoachForm from "./CoachForm";
import UserForm from "./UserForm";
import { preventdefault } from "react-dom";
import { useState } from "react";
import handleShowDetail from "./AuthComponent";
import handleClickCard from "./AuthComponent";
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

const CardCate = (props) => {
  const classes = useStyles();
  const { history } = props;

  return (
    <div>
      <Card className={classes.cardroot}>
        <CardActionArea>
          <CardMedia
            className={classes.media}
            image={props.image}
            title={props.title}
          />{" "}
          <CardContent>
            <Typography gutterBottom variant="h5" component="h2">
              {" "}
              {props.categoriesName}{" "}
            </Typography>{" "}
            <Typography variant="body2" color="textSecondary" component="p">
              Lorem ipsum dolor sit amet consectetur adipisicing elit.Asperiores
              magnam nihil eos dolor f{" "}
            </Typography>{" "}
          </CardContent>{" "}
        </CardActionArea>{" "}
        <CardActions>
          <Button size="small" color="primary">
            Joins us!
          </Button>{" "}
          <Button size="small" color="primary">
            Learn More{" "}
          </Button>{" "}
        </CardActions>{" "}
      </Card>{" "}
    </div>
  );
};
export default CardCate;
