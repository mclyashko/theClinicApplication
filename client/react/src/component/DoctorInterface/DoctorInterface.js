import React, {useEffect} from 'react';
import {useDispatch, useSelector} from "react-redux";
import {updateEmailPatternAction, updateFoundByEmailRecordListAction, updateVerdictByRecordIdAction} from "../../reducer/DoctorEmailSearchReducer/DoctorEmailSearchReducer";
import doctorFilterRecordsRequest from "../../util/request/doctor/doctorFilterRecordsRequest";
import doctorUpdateRecordVerdictRequest from "../../util/request/doctor/doctorUpdateRecordVerdictRequest";

async function getData(emailPattern) {
    const searchData = {
        email: emailPattern
    }

    return await doctorFilterRecordsRequest(searchData)
}

function DoctorInterface(props) {
    const name = useSelector(state => state.userInf.name)
    const emailPattern = useSelector(state => state.doctorEmailSearch.emailPattern)
    const recordList = useSelector(state => state.doctorEmailSearch.records) || []
    const verdicts = useSelector(state => state.doctorEmailSearch.verdicts)
    const dispatch = useDispatch()

    useEffect( () => {
        getData(emailPattern).then(
            (records) => dispatch(updateFoundByEmailRecordListAction(records))
        )
    }, [])

    return (
        <div className="wrapper">
            <div>
                <h1>Добрый день, {name}</h1>
            </div>
            <div style={{ padding: '15px' }}>
                <form>
                    <input value={emailPattern || ''} onChange={event => dispatch(updateEmailPatternAction(event.target.value))}
                        style={{ margin: '5px', width: '15%' }} type="email" id="email" name="email" className="form-control" placeholder="E-Mail"></input>
                </form>
                <button onClick={ async () => {
                    getData(emailPattern).then(
                        (records) => dispatch(updateFoundByEmailRecordListAction(records))
                    )
                }}
                    style={{ margin: '5px' }} type="submit">Осуществить поиск по e-mail</button>
            </div>
            <div>
                <h2>Список записей:</h2>
            </div>
            <table className="container table-bright table-bordered">
                {recordList.length === 0 ? <tbody><tr><td colSpan="2"> Нет записей</td></tr></tbody> :
                    <thead>
                        <tr>
                            <th className="col">ID и время записи</th>
                            <th className="col">Пол и дата рождения</th>
                            <th className="col">ФИО пациента</th>
                            <th className="col">Контактные данные пациента</th>
                            <th className="col">Информация о записи</th>
                            <th className="col">Добавить результаты</th>
                        </tr>
                    </thead>
                }
                <tbody>
                {
                    recordList.map(record => {
                        return (
                            <tr key={record.id}>
                                <td className="col">
                                    <div style={{ display: 'flex',  flexDirection: 'column' }}>
                                        <span>
                                            {`ID: ${record.id}`}
                                        </span>
                                        <span>
                                            {`Время записи: ${record.dateTime}`}
                                        </span>
                                    </div>
                                </td>
                                <td className="col">
                                    <div style={{ display: 'flex',  flexDirection: 'column' }}>
                                        <span>
                                            {`Пол: ${record.client.gender}`}
                                        </span>
                                        <span>
                                            {`Дата рождения: ${record.client.dateOfBirth}`}
                                        </span>
                                    </div>
                                </td>
                                <td className="col">
                                    <div style={{ display: 'flex',  flexDirection: 'column' }}>
                                        <span>{`Фамилия: ${record.client.surname}`}</span>
                                        <span>{`Имя: ${record.client.name}`}</span>
                                        <span>{`Отчество: ${record.client.surname}`}</span>
                                    </div>
                                </td>
                                <td className="col">
                                    <div style={{ display: 'flex',  flexDirection: 'column' }}>
                                        <span>{`Телефон: ${record.client.phoneNumber}`}</span>
                                        <span>{`E-mail: ${record.client.email}`}</span>
                                    </div>
                                </td>
                                <td className="col">
                                    <div style={{ display: 'flex',  flexDirection: 'column' }}>
                                        <span>{`Услуга: ${record.procedure.description}`}</span>
                                        <span>{`Стоимость: ${record.procedure.cost}`}</span>
                                    </div>
                                </td>
                                <td className="col">
                                    <div style={{display: 'flex', flexDirection: 'column', margin: '5px', padding: '5px'}}>
                                        <span>{`Вердикт по записи с ID: ${record.id}`}</span>
                                        <form>
                                            <input value={verdicts[record.id] || ''}
                                                   onChange={event => dispatch(updateVerdictByRecordIdAction({id: record.id, value: event.target.value}))}
                                                   type="text" id="verdict" name="verdict" className="form-control" placeholder="Вердикт">
                                            </input>
                                        </form>
                                        <button onClick={ async () => {
                                            let recordVerdictData = {
                                                id: record.id,
                                                verdict: verdicts[record.id]
                                            }

                                            await doctorUpdateRecordVerdictRequest(recordVerdictData)

                                            getData(emailPattern).then(
                                                (records) => dispatch(updateFoundByEmailRecordListAction(records))
                                            )
                                        }}
                                                type="submit" className="btn btn-secondary btn-block" style={{ width: '100%' }}>
                                            Добавить
                                        </button>
                                    </div>
                                </td>
                            </tr>
                        )
                    })
                }
                </tbody>
            {/*    <tr*/}
            {/*        // th:if="${records.isEmpty()}"*/}
            {/*    >*/}
            {/*        <td colSpan="2"> Нет записей</td>*/}
            {/*    </tr>*/}
            {/*    <thead*/}
            {/*        // th:if="${not records.isEmpty()}"*/}
            {/*    >*/}
            {/*    <tr>*/}
            {/*        <th>ID и время записи</th>*/}
            {/*        <th>Пол и дата рождения</th>*/}
            {/*        <th>ФИО пациента</th>*/}
            {/*        <th>Контактные данные пациента</th>*/}
            {/*        <th>Информация о записи</th>*/}
            {/*        <th>Добавить результаты</th>*/}
            {/*    </tr>*/}
            {/*    </thead>*/}
            {/*    <tbody*/}
            {/*        // th:if="${not records.isEmpty()}"*/}
            {/*    >*/}
            {/*    <tr*/}
            {/*        // th:each="record : ${records}"*/}
            {/*    >*/}
            {/*        <div className="row" style="display: inline-block;">*/}
            {/*            <td className="col">*/}
            {/*                <div style="display: flex; flex-direction: column"*/}
            {/*                     // th:inline="text"*/}
            {/*                >*/}
            {/*                    <span>*/}
            {/*                        /!*ID: [[${record.getId()}]]*!/*/}
            {/*                    </span>*/}
            {/*                    /!*<span>Время записи: [[${#temporals.format(record.getDateTime(), 'HH:mm:ss dd-MMM-yyyy')}]]</span>*!/*/}
            {/*                </div>*/}
            {/*            </td>*/}
            {/*            <td className="col">*/}
            {/*                <div style="display: flex; flex-direction: column"*/}
            {/*                     // th:inline="text"*/}
            {/*                >*/}
            {/*                    <span>*/}
            {/*                        /!*Пол: [[${record.getClient().getGender()}]]*!/*/}
            {/*                    </span>*/}
            {/*                    /!*<span>Дата рождения: [[${#dates.format(record.getClient().getDateOfBirth(), 'dd-MMM-yyyy')}]]</span>*!/*/}
            {/*                </div>*/}
            {/*            </td>*/}
            {/*            <td className="col">*/}
            {/*                <div style="display: flex; flex-direction: column"*/}
            {/*                     // th:inline="text"*/}
            {/*                >*/}
            {/*                    <span>Фамилия:*/}
            {/*                        /!*[[${record.getClient().getSurname()}]]*!/*/}
            {/*                    </span>*/}
            {/*                    <span>Имя:*/}
            {/*                        /!*[[${record.getClient().getName()}]]*!/*/}
            {/*                    </span>*/}
            {/*                    <span>Отчество:*/}
            {/*                        /!*[[${record.getClient().getPatronymic()}]]*!/*/}
            {/*                    </span>*/}
            {/*                </div>*/}
            {/*            </td>*/}
            {/*            <td className="col">*/}
            {/*                <div style="display: flex; flex-direction: column"*/}
            {/*                     // th:inline="text"*/}
            {/*                >*/}
            {/*                    <span>Телефон:*/}
            {/*                        /!*[[${record.getClient().getPhoneNumber()}]]*!/*/}
            {/*                    </span>*/}
            {/*                    <span>E-mail:*/}
            {/*                        /!*[[${record.getClient().getEmail()}]]*!/*/}
            {/*                    </span>*/}
            {/*                </div>*/}
            {/*            </td>*/}
            {/*            <td className="col">*/}
            {/*                <div style="display: flex; flex-direction: column"*/}
            {/*                     // th:inline="text"*/}
            {/*                >*/}
            {/*                    <span>Услуга:*/}
            {/*                        /!*[[${record.getProcedure().getDescription()}]]*!/*/}
            {/*                    </span>*/}
            {/*                    <span>Стоимость:*/}
            {/*                        /!*[[${record.getProcedure().getCost()}]]*!/*/}
            {/*                    </span>*/}
            {/*                </div>*/}
            {/*            </td>*/}
            {/*            <td className="col">*/}
            {/*                <div style="display: flex; flex-direction: column; margin: 5px; padding: 5px;"*/}
            {/*                     // th:inline="text"*/}
            {/*                >*/}
            {/*                    <span>Вердикт по записи с ID*/}
            {/*                        /!*[[${record.getId()}]]*!/*/}
            {/*                    </span>*/}
            {/*                    <form*/}
            {/*                        // th:action="@{/record_data}" th:object="${recordData}"*/}
            {/*                    method="post">*/}
            {/*                        <input type="hidden"*/}
            {/*                               // th:value="${record.getId()}"*/}
            {/*                        name="id">*/}
            {/*                            <input type="text" id="verdict" name="verdict" className="form-control" placeholder="Вердикт">*/}
            {/*                                <button type="submit" className="btn btn-secondary btn-block" style="width: 100%;">*/}
            {/*                                    Добавить*/}
            {/*                                </button>*/}
            {/*                            </input>*/}
            {/*                        </input>*/}
            {/*                    </form>*/}
            {/*                </div>*/}
            {/*            </td>*/}
            {/*        </div>*/}
            {/*    </tr>*/}
            {/*    </tbody>*/}
            </table>
        </div>
    );
}

export default DoctorInterface;
