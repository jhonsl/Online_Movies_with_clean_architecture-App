import React from 'react';
import logo from '../media/logo.png'

const Navbar = () => {
    return (       
        <div className='row'>
            <nav className='navbar navbar-dark bg-primary mb-5'>
            <div className='container'>
                <a className='navbar-brand' href='#'>
                <div className='row'>
                    <div className='col-2'>
                    <img src={logo} alt='popcorn' style={{ width: '50px' }} />
                    </div>
                    <div className='col-10'>
                    <h1>Sofka Movies</h1>
                    </div>
                </div>
                </a>
            </div>
            </nav>
        </div> 
  );
}

export default Navbar;