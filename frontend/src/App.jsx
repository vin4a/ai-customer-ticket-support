import Navbar from './components/Navbar.jsx'
import WelcomeMessage from './components/WelcomeMessage.jsx'
import Counter from './components/Counter.jsx'
import EventExample from './components/EventExample'
import LoginForm from './components/LoginForm.jsx'
import './App.css'

function App() {
  return (
    <>
      <Navbar />

      <WelcomeMessage name="Ivanna" />

      <Counter />

      <EventExample />

      <LoginForm />
    </>
    
  )
}

export default App
