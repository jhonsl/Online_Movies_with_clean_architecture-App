import actionsTypesCatalogs from './ActionTypes';

export const CatalogsLoading = () => {
  return {
    type: actionsTypesCatalogs.LOADING_SUCCESS_CATALOGS
  }
}

export const CatalogsLoadSucces = (carteleras) => {
  return {
    type: actionsTypesCatalogs.LOAD_SUCCESS_CATALOGS,
    payload: carteleras
  }
}

export const CatalogsLoadError = (error) => {
  return {
    type: actionsTypesCatalogs.LOAD_FAILURE_CATALOGS,
    payload: error
  }
}