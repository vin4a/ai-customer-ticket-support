import { useState } from 'react'

function EventExample() {
    const [name, setName] = useState('')

    function handleChange(event) {
        setName(event.target.value)
    }

    return (
        <div>
            <input type="text" onChange={handleChange} />
            <p>Hello, {name} 🎀</p>
        </div>
    )
}

export default EventExample
