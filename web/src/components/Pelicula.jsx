import { Accordion } from 'react-bootstrap'
import { useState } from 'react'

function Pelicula ({ pelicula }) {
  return (
    <>
      <Accordion defaultActiveKey='1' flush>
        <Accordion.Item eventKey='0'>
          <Accordion.Header>
            <div className='col-md-4 d-flex justify-content-center align-self-center'>
              <img style={{borderRadius: 10}} height="200" src={pelicula.urlImage}/>
            </div>
            <div className='col-md-8'>
              <h1>{pelicula.nombrePelicula}</h1>
            </div>
          </Accordion.Header>
          <Accordion.Body className='row g-0'>
            <div className='col-md-8'>
              {console.log(pelicula)}
              <p><strong>categoria: </strong>{pelicula.categoria}</p>
              <p><strong>Sinopsis: </strong>{pelicula.sipnosis}</p>
              <p><strong>Sinopsis: </strong>{pelicula.urlVideo}</p>
            </div>
            <div className='d-flex justify-content-center'>
              <iframe width="560" height="315" src={pelicula.urlVideo} frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowFullScreen={true}/>
            </div>
          </Accordion.Body>
        </Accordion.Item>
      </Accordion>
    </>
  )
}

export default Pelicula