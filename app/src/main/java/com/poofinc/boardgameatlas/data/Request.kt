package com.poofinc.boardgameatlas.data

import com.poofinc.boardgameatlas.core.net.APIRequest

class Request {
    lateinit var request: APIRequest<APIResponse>
    lateinit var title: String
    lateinit var type: DataType
}