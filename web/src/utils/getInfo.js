import axios from 'axios';
import { CatalogsLoading, CatalogsLoadSucces, CatalogsLoadError } from '../actions/carteleraActions'

export const getInfo = () => (dispatch) => {
  dispatch(CatalogsLoading())

  const options = {
    method: 'GET',
    url: 'http://localhost:8080/api/cartelera/all'
  }

  axios.request(options).then(function (response) {
    dispatch(CatalogsLoadSucces(response.data))
  }).catch(function (error) {
    dispatch(CatalogsLoadError(error))
  })
}