export const serverUrl = "http://158.160.23.168:8080"

async function bodyRequester(relativeUrl, method, body = null, contentType = "application/json") {
    let init = {
        method: method,
        credentials: "include",
    }
    if (body !== null) {
        init = {
            ...init,
            body: body,
            headers: {
                'Accept': contentType,
                'Content-Type': contentType
            }
        }
    }
    console.log(init)
    return await fetch(`${serverUrl}${relativeUrl}`, init)
        .then((response) => {
            return response.json()
        })
        .then((data) => {
            console.log(data)
            return data
        })
}

async function simpleRequester(relativeUrl, method, body = null, contentType = "application/json") {
    let init = {
        method: method,
        credentials: "include",
    }
    if (body !== null) {
        init = {
            ...init,
            body: body,
            headers: {
                'Accept': contentType,
                'Content-Type': contentType
            }
        }
    }
    console.log(init)
    return await fetch(`${serverUrl}${relativeUrl}`, init)
}

export {bodyRequester, simpleRequester}
