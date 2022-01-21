import actionsTypesCatalogs from '../actions/ActionTypes'

const initialState = {
  isLoading: false,
  carteleras: null,
  error: null
}

const CarteleraReducer = (state = initialState, { type, payload }) => {
  switch (type) {
    case actionsTypesCatalogs.LOADING_SUCCESS_CATALOGS:
      return {
        ...state,
        isLoading: true
      }
    case actionsTypesCatalogs.LOAD_SUCCESS_CATALOGS:
      return {
        ...state,
        isLoading: false,
        carteleras: payload
      }
    case actionsTypesCatalogs.LOAD_FAILURE_CATALOGS:
      return {
        ...state,
        isLoading: false,
        error: payload
      }

    default: return state
  }
}

export default CarteleraReducer