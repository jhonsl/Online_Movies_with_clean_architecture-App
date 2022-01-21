import { useDispatch, useSelector } from 'react-redux'
import { useEffect } from 'react'
import { getInfo } from '../utils/getInfo'
import Pelicula from './Pelicula'

function Cartelera() {
  const dispatch = useDispatch()
  const { isLoading, carteleras, error } = useSelector(state => state.carteleras)

  useEffect(() => {
    dispatch(getInfo())
  }, [])

  useEffect(() => {
    const socket = new WebSocket('ws://' + 'localhost:8080' + '/retrieve/' + 'xxxx-xxxx')
    socket.onmessage = function (m) {
      const data = JSON.parse(m.data)
      console.log('Got message: ' + data.type)
      dispatch(getInfo())
    }
  }, [])

  return (
    <>
      {carteleras && carteleras.map((cartelera) => {
        return (
          <div key={cartelera._id} style={{ width: '100%' }}>
            <div >
              <h1 className='text-center'>{cartelera.nombre}</h1>
                {cartelera.peliculas &&
                  Object.keys(cartelera.peliculas).map((key) => {
                    return (
                      <div key={key}>
                        <hr/>
                        <Pelicula pelicula={cartelera.peliculas[key]} />
                        <hr />
                      </div>
                    )
                  })}
            </div>
          </div>
        )
      })}
      {isLoading && <h1>Cargando...</h1>}
      {error && <h1>Error {error}</h1>}
    </>
  )
}

export default Cartelera