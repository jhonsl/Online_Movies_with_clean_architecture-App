import 'bootstrap/dist/css/bootstrap.min.css'
import Cartelera from './components/Cartelera'
import Navbar from './components/Navbar'


function App () {
  return (
    <div className='App'>
      <Navbar/>
      <div className='row'>
        <div className='col-8 offset-2'>
          <Cartelera />
        </div>
      </div>
    </div>
  )
}

export default App
