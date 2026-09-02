import {useState} from 'react'

function LoginForm() {
    const [email, setEmail] = useState('')
    const [password, setPassword] = useState('')

    function handleEmailChange(event){
        setEmail(event.target.value)
    }

    function handlePasswordChange(event){
        setPassword(event.target.value)
    }

    function handleSubmit(event){
        event.preventDefault()
        console.log("Email:", email)
        console.log("Password:", password)
    }

    return (
        <form onSubmit={handleSubmit}>
            <div>
                <label>Email:</label>
                <input type = "email" onChange={handleEmailChange}/>
            </div>
            <div>
                <label>Password:</label>
                <input type = "password" onChange={handlePasswordChange}/>
            </div>
            <button type="submit">Login</button>
        </form>
    )
}

export default LoginForm