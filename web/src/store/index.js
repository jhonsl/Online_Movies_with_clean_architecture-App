import { combineReducers } from 'redux'
import CarteleraReducer from '../reducers/CarteleraReducer'

const rootReducer = () => {
  return combineReducers(
    {
      carteleras: CarteleraReducer
    }
  )
}

export default rootReducer