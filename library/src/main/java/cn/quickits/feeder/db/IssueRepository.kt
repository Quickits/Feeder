package cn.quickits.feeder.db

class IssueRepository private constructor(private val issueDao: IssueDao) {

    fun getIssues() = issueDao.getIssues()

    companion object {

        @Volatile
        private var instance: IssueRepository? = null

        fun getInstance(issueDao: IssueDao) =
            instance ?: synchronized(this) {
                instance ?: IssueRepository(issueDao).also { instance = it }
            }
    }

}