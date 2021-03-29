import React , {useState} from 'react';
import { makeStyles } from '@material-ui/core/styles';
import GridList from '@material-ui/core/GridList';
import GridListTile from '@material-ui/core/GridListTile';
import GridListTileBar from '@material-ui/core/GridListTileBar';
import ListSubheader from '@material-ui/core/ListSubheader';
import IconButton from '@material-ui/core/IconButton';
import InfoIcon from '@material-ui/icons/Info';
import { withRouter } from 'react-router';
import image from '../../img/Yoga.jpg';
import muscu from '../../img/fitness.jpg'


const useStyles = makeStyles((theme) => ({
  root: {
    padding : '10px',
    display: 'flex',
    flexWrap: 'wrap',
    justifyContent: 'space-around',
    overflow: 'hidden',
    backgroundColor: theme.palette.background.paper,
  },
  gridList: {
    minWidth: 500,
    minHeight: 450,
  },
  icon: {
    color: 'rgba(255, 255, 255, 0.54)',
  },
}));


  const tileData = [
    {
      img: image,
      title: 'Yoga',
      author: 'author',
   }, 
   {
    img: muscu,
    title: 'Gainage',
    author: 'author',
 },
 {
  img: muscu,
  title: 'pdc',
  author: 'author',
}
    
  ];
 
function GridCate() {
  const [categorie , setCategorie] = useState({});
  const [isClicked , setIsClicked] = useState(false);
  const classes = useStyles();


 const handleClickCate = () => {
setIsClicked(!isClicked)
console.log(isClicked);
  }

  return (
    <form className={classes.root}>
      <GridList cellHeight={180} className={classes.gridList}>
        <GridListTile key="Subheader" cols={2} style={{ height: 'auto' }}>
        </GridListTile>
        {tileData.map((tile) => (
          <GridListTile 
          onClick = {handleClickCate}
          key={tile.img}>
            <img src={tile.img} alt={tile.title} />
            <GridListTileBar
              title={tile.title}
              subtitle={<span>by: {tile.author}</span>}
              actionIcon={
                <IconButton aria-label={`info about ${tile.title}`} className={classes.icon}>
                  <InfoIcon />
                </IconButton>
              }
            />
          </GridListTile>
        ))}
      </GridList>
      <button type='submit '> Soumettre </button>
    </form>
  );
}
export default withRouter(GridCate);
