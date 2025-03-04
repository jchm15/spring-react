import {useEffect, useState} from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'

import {API_BASE_URL, APP_NAME, APP_VERSION} from "./config";

import axios from "axios";

function App() {
    const [count, setCount] = useState(0)

    useEffect(() => {
        let params = {
            name: "hm",
            age: 30
        }
        axios.post("/api/hello", params)
            .then((response) => {
                console.log(response)
                console.log(response.data.body)
            })
            .catch((error) => {
                console.log(error)
            })
            .finally(() => {
                console.log("finally")
            })
    }, [])

    return (
        <>
            <div>
                <h1>{APP_NAME}</h1>
                <p>API URL: {API_BASE_URL}</p>
                <p>Version: {APP_VERSION}</p>
            </div>
            <div>
                <a href="https://vite.dev" target="_blank">
                    <img src={viteLogo} className="logo" alt="Vite logo"/>
                </a>
                <a href="https://react.dev" target="_blank">
                    <img src={reactLogo} className="logo react" alt="React logo"/>
                </a>
            </div>
            <h1>Vite + React</h1>
            <div className="card">
                <button onClick={() => setCount((count) => count + 1)}>
                    count is {count}
                </button>
                <p>
                    Edit <code>src/App.tsx</code> and save to test HMR
                </p>
            </div>
            <p className="read-the-docs">
                Click on the Vite and React logos to learn more
            </p>
        </>
    )
}

export default App
