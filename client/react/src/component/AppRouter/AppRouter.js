import {Routes, Route, Navigate} from "react-router-dom";
import {LOGIN_ROUTE} from "../../util/consts";
import {publicRoutes} from "../../util/routes";

export const AppRouter = () => {
    return (
        <Routes>
            {publicRoutes.map(({path, Element}) =>
                <Route key={path} path={path} element={<Element/>} exact></Route>
            )}
            <Route path = "*" element={<Navigate to = {LOGIN_ROUTE} replace/>}></Route>
        </Routes>
    )
}

export default AppRouter
